package com.epam.servicetest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Test;

import com.epam.service.Task;
/**.
 * task unit testing
 * @author Farhaan_Shaik
 *
 */
public class TaskTest {
    /**.
     * testing parking method
     * @throws Exception 
     */
	@Test
	public void parkTest() throws Exception {
		Task task = new Task(3);
		assertEquals("11", task.park("ap07ey7777", 3, 0));
		assertEquals("21", task.park( "ts11pk7777", 3, 1));
		assertEquals("31", task.park( "ap07ey1234", 3, 2));
		assertEquals("43", task.park( "ap07ey7777", 3, 4));
	}
	/**.
	 * testing unparking of method
	 * @throws Exception 
	 */
	@Test
	public void UnParkTest() throws Exception {
		Task task = new Task(3);
		assertFalse(task.unPark("ap07ey7777"));
		task.park( "ap07ey7777", 3, 1);
		task.park( "ts11pk7777", 3, 2);
		assertTrue(task.unPark("ap07ey7777"));
		assertTrue(task.unPark("ts11pk7777"));
	}
	/**.
	 * testing if a slot is available or not
	 * @throws Exception 
	 */
	@Test
	public void availableSlotTest() throws Exception {
		Task task = new Task(3);
		task.park( "ap07ey7777", 3, 0);
		task.park( "ts11pk7777", 3, 1);
		task.unPark("ap07ey7777");
		assertEquals(1, task.availableSlot("ap07ey7777"));
	}
}
