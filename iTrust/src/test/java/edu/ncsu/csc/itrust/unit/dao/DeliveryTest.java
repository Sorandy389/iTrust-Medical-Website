package edu.ncsu.csc.itrust.unit.dao;

import edu.ncsu.csc.itrust.model.old.beans.DeliveryBean;
import edu.ncsu.csc.itrust.model.old.dao.DAOFactory;
import edu.ncsu.csc.itrust.model.old.dao.mysql.DeliveryDAO;
import edu.ncsu.csc.itrust.unit.datagenerators.TestDataGenerator;
import edu.ncsu.csc.itrust.unit.testutils.TestDAOFactory;
import junit.framework.TestCase;

public class DeliveryTest extends TestCase {
    private DAOFactory factory;
    private long mid = 1L;
    private long hcpId = 9000000000L;
    TestDataGenerator gen;
    private DeliveryDAO deliveryDAO;


    @Override
    protected void setUp() throws Exception {
        gen = new TestDataGenerator();
        gen.clearAllTables();
        gen.standardData();

        this.factory = TestDAOFactory.getTestInstance();
        deliveryDAO = new DeliveryDAO(this.factory);
    }

    public void testEditAndDeleteDelivery() throws Exception {

        DeliveryBean deliveryBean = new DeliveryBean();
        deliveryBean.setMotherID(12);
        deliveryBean.setPatientID(2);
        deliveryBean.setMotherID(1);
        deliveryBean.setSex("Male");
        deliveryBean.setChildHospitalVisitID(1);
        deliveryBean.setDeliverDate("2018-11-13");
        deliveryBean.setDeliverTime("08:00 A.M");

        long id = deliveryDAO.addDelivery(deliveryBean);
        deliveryBean.setId(id);
        deliveryBean.setDeliverTime("3456");
        boolean success = deliveryDAO.editDelivery(deliveryBean);
        assertTrue(success);

        deliveryDAO.deleteDelivery(deliveryBean.getPatientID());

    }
}
