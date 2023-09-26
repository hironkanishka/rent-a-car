package dao;


public class DaoFactory {

    private static DaoFactory daoFactory;

    private DaoFactory() { }

    public static DaoFactory getInstance(){
        if (daoFactory == null) {
            daoFactory=new DaoFactory();
        } return  daoFactory;
    }

    public static SuperDao getDao(DaoType type){
        switch(type) {
            case USER:
               return new UserDaoImpl();
            case CATEGORY:
                return new CategoryDaoImpl();
            case CAR:
                return new CarDaoImpl();
            default:
                return null;
        }

    }

    public enum DaoType{
        CATEGORY ,CUSTOMER ,CAR,RENT,USER
    }
}
