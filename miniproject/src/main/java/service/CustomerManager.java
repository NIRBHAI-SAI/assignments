package service;

import Dao.CustomerDao;
import Dao.DaoException;
import Dao.DaoFactory;
import model.Customer;

import java.util.List;
import java.util.Objects;

public class CustomerManager {

    // this class has a dependency on an object of CustomerDao
    private CustomerDao dao;

    public CustomerManager() throws ServiceException {
        // tight coupling of dependency
        // must be converted to a loose coupling
        // this.dao = new CsvFileCustomerDao();
        // this.dao = new ArrayListCustomerDao();

        // here is the solution; loose coupling;
        // CustomerManager asks somebody to give an object of CustomerDao
        try {
            this.dao = DaoFactory.getCustomerDao();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public List<Customer> getAll() throws ServiceException {
        try {
            return dao.getAll();
        }
        catch (DaoException e){
            throw new ServiceException(e);
        }
    }

    public Customer addNewCustomer(Customer customer) throws ServiceException{
        try{
            // we can do some validation here before saving.

            return dao.save(customer);
        }
        catch (DaoException e){
            throw new ServiceException(e);
        }
    }

    public List<Customer> getById(int id) throws ServiceException{
        try{
            return dao.getAll().stream().filter(c->c.getId() == id).toList();
        }catch (DaoException e){
            throw new ServiceException();
        }
    }

    public List<Customer> getByEmail(String email) throws ServiceException{
        try{
            return dao.getAll().stream()
                    .filter(customer -> email.equalsIgnoreCase(customer.getEmail())).toList();
        }catch (DaoException e){
            throw new ServiceException();

        }
    }

    public List<Customer> getByCity (String city) throws ServiceException{
        try{
            return dao.getAll().stream()
                    .filter(customer -> city.equalsIgnoreCase(customer.getCity())).toList();
        }catch (DaoException e){
            throw new ServiceException();
        }
    }

    public List<Customer> getByPhone(String phno) throws ServiceException{
        try{
            return dao.getAll().stream().filter(c->phno.equals(c.getPhone())).toList();
        }catch (DaoException e){
            throw new ServiceException();
        }
    }
}