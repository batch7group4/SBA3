package ibs.model;


public class RoleModel {
	
	private Integer roleId;
	private String roleName;
	private String rolePrivilage;
	
	public RoleModel() {
		super();
	}
	
	public RoleModel(Integer roleId, String roleName, String rolePrivilage) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.rolePrivilage = rolePrivilage;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRolePrivilage() {
		return rolePrivilage;
	}

	public void setRolePrivilage(String rolePrivilage) {
		this.rolePrivilage = rolePrivilage;
	}
	
	
}
