package se.skltp.aggregatingservices.riv.clinicalprocess.activityprescription.actoutcome.getaggregatedvaccinationhistory.v1;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import riv.clinicalprocess.activityprescription.actoutcome.getvaccinationhistoryresponder.v1.GetVaccinationHistoryResponseType;
import se.skltp.aggregatingservices.api.AgpServiceFactory;
import se.skltp.aggregatingservices.tests.CreateAggregatedResponseTest;
import se.skltp.aggregatingservices.data.TestDataGenerator;


@RunWith(SpringJUnit4ClassRunner.class)
public class GAVH1CreateAggregatedResponseTest extends CreateAggregatedResponseTest {

  private static GAVH1AgpServiceConfiguration configuration = new GAVH1AgpServiceConfiguration();
  private static AgpServiceFactory<GetVaccinationHistoryResponseType> agpServiceFactory = new GAVH1AgpServiceFactoryImpl();
  private static ServiceTestDataGenerator testDataGenerator = new ServiceTestDataGenerator();

  public GAVH1CreateAggregatedResponseTest() {
      super(testDataGenerator, agpServiceFactory, configuration);
  }

  @Override
  public int getResponseSize(Object response) {
        GetVaccinationHistoryResponseType responseType = (GetVaccinationHistoryResponseType)response;
    return responseType.getVaccinationMedicalRecord().size();
  }
}