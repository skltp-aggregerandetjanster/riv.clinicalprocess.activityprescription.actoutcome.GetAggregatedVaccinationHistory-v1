package se.skltp.aggregatingservices.riv.clinicalprocess.activityprescription.actoutcome.getaggregatedvaccinationhistory.v1;

import lombok.extern.log4j.Log4j2;
import org.apache.cxf.message.MessageContentsList;
import org.springframework.stereotype.Service;
import riv.clinicalprocess.activityprescription.actoutcome.getvaccinationhistoryresponder.v1.GetVaccinationHistoryResponseType;
import riv.clinicalprocess.activityprescription.actoutcome.getvaccinationhistoryresponder.v1.GetVaccinationHistoryType;
import riv.clinicalprocess.activityprescription.actoutcome.v1.PatientSummaryHeaderType;
import riv.clinicalprocess.activityprescription.actoutcome.v1.PersonIdType;
import riv.clinicalprocess.activityprescription.actoutcome.v1.VaccinationMedicalRecordBodyType;
import riv.clinicalprocess.activityprescription.actoutcome.v1.VaccinationMedicalRecordType;
import se.skltp.aggregatingservices.data.TestDataGenerator;

@Log4j2
@Service
public class ServiceTestDataGenerator extends TestDataGenerator {

  @Override
  public String getPatientId(MessageContentsList messageContentsList) {
    GetVaccinationHistoryType request = (GetVaccinationHistoryType) messageContentsList.get(1);
    String patientId = request.getPatientId().getId();
    return patientId;
  }

  @Override
  public Object createResponse(Object... responseItems) {
    log.info("Creating a response with {} items", responseItems.length);
    GetVaccinationHistoryResponseType response = new GetVaccinationHistoryResponseType();
    for (int i = 0; i < responseItems.length; i++) {
      response.getVaccinationMedicalRecord().add((VaccinationMedicalRecordType) responseItems[i]);
    }
    log.info("response.toString:" + response.toString());
    return response;
  }

  @Override
  public Object createResponseItem(String logicalAddress, String registeredResidentId,
      String businessObjectId, String time) {
    log.debug(
        "Created ResponseItem for logical-address {}, registeredResidentId {} and businessObjectId {}",
        new Object[]{logicalAddress, registeredResidentId, businessObjectId});
    VaccinationMedicalRecordType responce = new VaccinationMedicalRecordType();
    responce.setVaccinationMedicalRecordBody(new VaccinationMedicalRecordBodyType());
    responce.setVaccinationMedicalRecordHeader(new PatientSummaryHeaderType());
    responce.getVaccinationMedicalRecordHeader().setPatientId(new PersonIdType());
    responce.getVaccinationMedicalRecordHeader().getPatientId().setId(registeredResidentId);
    return responce;
  }

  public Object createRequest(String patientId, String sourceSystemHSAId) {
    GetVaccinationHistoryType request = new GetVaccinationHistoryType();
    request.setSourceSystemHSAid(sourceSystemHSAId);
    PersonIdType person = new PersonIdType();
    person.setId(patientId);
    request.setPatientId(person);
    return request;
  }
}
