package se.skltp.aggregatingservices.riv.clinicalprocess.activityprescription.actoutcome.getaggregatedvaccinationhistory.v1;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import riv.clinicalprocess.activityprescription.actoutcome.getvaccinationhistoryresponder.v1.GetVaccinationHistoryResponseType;
import se.skltp.aggregatingservices.api.AgpServiceFactory;
import se.skltp.aggregatingservices.tests.CreateFindContentTest;
import se.skltp.aggregatingservices.data.TestDataGenerator;
import se.skltp.aggregatingservices.tests.CreateRequestListTest;

@RunWith(SpringJUnit4ClassRunner.class)
public class GAVH1CreateRequestListTest extends CreateRequestListTest {

  private static GAVH1AgpServiceConfiguration configuration = new GAVH1AgpServiceConfiguration();
  private static AgpServiceFactory<GetVaccinationHistoryResponseType> agpServiceFactory = new GAVH1AgpServiceFactoryImpl();
  private static ServiceTestDataGenerator testDataGenerator = new ServiceTestDataGenerator();


  public GAVH1CreateRequestListTest() {
    super(testDataGenerator, agpServiceFactory, configuration);
  }

}