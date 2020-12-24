package ibs.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="SERVICE_PROVIDER")
public class ServiceProviderEntity {

	
	@Id
	@Column(name="SERVICE_PROVIDER_ID")
	@GeneratedValue
	private Integer serviceProviderId;
	
	@OneToOne
	@JoinColumn(name="regstrId")
	private RegistrationEntity  svcRegId;
	
	@Column(name="SVC_PRVDR_NM")
	private String serviceProviderName;
	
	@Column(name="BNK_NM")
	private String serviceProviderBank;

	
	public ServiceProviderEntity() {
		super();
	}

	public ServiceProviderEntity(Integer serviceProviderId, RegistrationEntity svcRegId, String serviceProviderName,
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

	public RegistrationEntity getSvcRegId() {
		return svcRegId;
	}

	public void setSvcRegId(RegistrationEntity svcRegId) {
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
