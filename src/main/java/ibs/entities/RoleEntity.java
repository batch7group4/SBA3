package ibs.entities;


public class RoleEntity {
	
	private Integer roleId;
	private String roleName;
	private String rolePrivilage;
	
	public RoleEntity() {
		super();
	}
	
	public RoleEntity(Integer roleId, String roleName, String rolePrivilage) {
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
