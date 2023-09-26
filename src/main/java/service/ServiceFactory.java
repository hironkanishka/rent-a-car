package service;


public class ServiceFactory {

    private static ServiceFactory serviceFactory;

    private ServiceFactory() { }

    public static ServiceFactory getInstance(){
        if (serviceFactory == null) {
            serviceFactory=new ServiceFactory();
        } return  serviceFactory;
    }

    public static SuperService getService(ServiceType serviceType){
        switch(serviceType) {
            case USER:
               return new UserServiceImpl();
            case CATEGORY:
                return new CategoryServiceImpl();
            case CAR:
                return new CarServiceImpl();
            default:
                return null;
        }

    }

    public enum ServiceType{
        CATEGORY ,CUSTOMER ,CAR,RENT,USER
    }
}
