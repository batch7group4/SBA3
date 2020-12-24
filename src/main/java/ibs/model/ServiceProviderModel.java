package ibs.model;

public class ServiceProviderModel {


	private Integer serviceProviderId;
	private RegistrationModel  svcRegId;
	private String serviceProviderName;
	private String serviceProviderBank;
	
	public ServiceProviderModel() {
		super();
	}

	public ServiceProviderModel(Integer serviceProviderId, RegistrationModel svcRegId, String serviceProviderName,
			String serviceProviderBank) {
		super();
		this.serviceProviderId = serviceProviderId;
		this.svcRegId = svcRegId;
		this.serviceProviderName = serviceProviderName;
		this.serviceProviderBank = serviceProviderBank;
		
	}

	public Integer getServiceProviderId() {
		return serviceProviderId;
	}

	public void setServiceProviderId(Integer serviceProviderId) {
		this.serviceProviderId = serviceProviderId;
	}

	public RegistrationModel getSvcRegId() {
		return svcRegId;
	}

	public void setSvcRegId(RegistrationModel svcRegId) {
		this.svcRegId = svcRegId;
	}

	public String getServiceProviderName() {
		return serviceProviderName;
	}

	public void setServiceProviderName(String serviceProviderName) {
		this.serviceProviderName = serviceProviderName;
	}

	public String getServiceProviderBank() {
		return serviceProviderBank;
	}

	public void setServiceProviderBank(String serviceProviderBank) {
		this.serviceProviderBank = serviceProviderBank;
	}


	
}
