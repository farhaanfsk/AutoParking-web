package com.epam.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**.
 * 
 * @author Farhaan_Shaik
 *
 */
@Entity
@Table(name = "autoparkingadmin")
public class Admin {
	/**.
	 * admin id number
	 */
	@Id
    private int id;
    /**.
     * admin password
     */
    private String password;
    /**.
     * admin role
     */
    private String role;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
