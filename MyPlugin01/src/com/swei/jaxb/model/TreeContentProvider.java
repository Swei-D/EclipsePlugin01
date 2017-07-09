package com.swei.jaxb.model;

import java.util.List;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class TreeContentProvider implements IStructuredContentProvider, ITreeContentProvider{

	@Override
	public Object[] getChildren(Object parentElement) {
		Itree node = (Itree) parentElement;
		List list = node.getChildren();
		if(list == null){
			return new Object[0];
		}
		return list.toArray();
	}

	@Override
	public Object getParent(Object arg0) {
		return null;
	}

	public boolean hasChildren(Object element) {
		Itree node = (Itree) element;
		List list = node.getChildren();
		return !(list == null || list.isEmpty());
	}

	@Override
	public Object[] getElements(Object inputElement) {
		if(inputElement instanceof List){
			List input = (List) inputElement;
			return input.toArray();
		}
		return new Object[0];
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inputChanged(Viewer arg0, Object arg1, Object arg2) {
		// TODO Auto-generated method stub
		
	}

}
