package com.example.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.ui.views.properties.ComboBoxPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;

/**
 * @author Swei
 *
 */
public class Node extends Element implements IPropertySource {
	final public static String PROP_LOCATION = "LOCATION";

	final public static String PROP_NAME = "NAME";

	final public static String PROP_VISIBLE = "VISIBLE";

	final public static String PROP_INPUTS = "INPUTS";

	final public static String PROP_OUTPUTS = "OUTPUTS";

	protected Point location = new Point(0, 0);

	protected String name = "Node";

	protected boolean visible = true;
	/**************************************************2017.7.9 15:51*********************************************************************/
	final public static String PROP_MY = "MY";
	protected String my = "My";
	/***********************************************************************************************************************/
	/**
	 * 在属性视图里添加显示新的属性值
	 * 主要是三个地方：首先要在你的IPropertyDescriptor[]变量里增加对应的描述，包括属性名和属性编辑方式（比如文本或是下拉框，如果是后者还要指定选项列表），其次是getPropertyValue()和setPropertyValue()里增加读取属性值和将结果写入的代码
	 * 新建属性变量 my， 并设置其gettter和setter方法
	 */
	protected IPropertyDescriptor[] descriptors = new IPropertyDescriptor[] {
			new TextPropertyDescriptor(PROP_NAME, "Name"),
			new ComboBoxPropertyDescriptor(PROP_VISIBLE, "Visible", new String[] { "true", "false" }), 
			new TextPropertyDescriptor(PROP_MY, "My") };
	/***********************************************************************************************************************/
	protected List outputs = new ArrayList(5);

	protected List inputs = new ArrayList(5);

	public void addInput(Connection connection) {
		this.inputs.add(connection);
		fireStructureChange(PROP_INPUTS, connection);
	}

	public void addOutput(Connection connection) {
		this.outputs.add(connection);
		fireStructureChange(PROP_OUTPUTS, connection);
	}

	public List getIncomingConnections() {
		return this.inputs;
	}

	public List getOutgoingConnections() {
		return this.outputs;
	}

	public void removeInput(Connection connection) {
		this.inputs.remove(connection);
		fireStructureChange(PROP_INPUTS, connection);
	}

	public void removeOutput(Connection connection) {
		this.outputs.remove(connection);
		fireStructureChange(PROP_OUTPUTS, connection);
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		if (this.visible == visible) {
			return;
		}
		this.visible = visible;
		firePropertyChange(PROP_VISIBLE, null, Boolean.valueOf(visible));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (this.name.equals(name)) {
			return;
		}
		this.name = name;
		firePropertyChange(PROP_NAME, null, name);
	}

	public void setLocation(Point p) {
		if (this.location.equals(p)) {
			return;
		}
		this.location = p;
		firePropertyChange(PROP_LOCATION, null, p);
	}

	public Point getLocation() {
		return location;
	}
	/***********************************************************************************************************************/
	public String getMy() {
		return my;
	}

	public void setMy(String my) {
		if (this.my.equals(my)) {
			return;
		}
		this.my = my;
		firePropertyChange(PROP_MY, null, my);
	}
	/***********************************************************************************************************************/

	// ------------------------------------------------------------------------
	// Abstract methods from IPropertySource

	public Object getEditableValue() {
		return this;
	}

	public IPropertyDescriptor[] getPropertyDescriptors() {
		return descriptors;
	}
	public Object getPropertyValue(Object id) {
		if (PROP_NAME.equals(id))
			return getName();
		if (PROP_VISIBLE.equals(id))
			return isVisible() ? new Integer(0) : new Integer(1);
		/***********************************************************************************************************************/
		if(PROP_MY.equals(id))
			return getMy();
		/***********************************************************************************************************************/
		return null;
	}
	public boolean isPropertySet(Object id) {
		return true;
	}

	public void resetPropertyValue(Object id) {

	}
	public void setPropertyValue(Object id, Object value) {
		if (PROP_NAME.equals(id))
			setName((String) value);
		if (PROP_VISIBLE.equals(id))
			setVisible(((Integer) value).intValue() == 0);
		/***********************************************************************************************************************/
		if(PROP_MY.equals(id))
			setMy((String) value);
		/***********************************************************************************************************************/
	}
}