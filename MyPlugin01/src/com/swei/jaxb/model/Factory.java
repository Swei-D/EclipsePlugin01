package com.swei.jaxb.model;

import java.util.ArrayList;
import java.util.List;

public class Factory {

	public static List createTree(){
		//���ɹ���
		Country cn = new Country("�й�");
		Country us = new Country("����");
		Country jp = new Country("�ձ�");
		
		//���ɳ���
		City beijing = new City("����");
		City shanghai = new City("�Ϻ�");
		City newyork = new City("ŦԼ");
		City la = new City("��ɼ�");
		City tokyo = new City("����");
		City osaka = new City("����");
		
		//������
		ArrayList list = new ArrayList<>();
		list.add(new People("����"));
		list.add(new People("����"));
		list.add(new People("����"));
		beijing.setChildren(list);
		
		//�Ϻ���
		list = new ArrayList<>();
		list.add(new People("�仨"));
		list.add(new People("С��"));
		list.add(new People("С��"));
		shanghai.setChildren(list);

		//ŦԼ��
		list = new ArrayList<>();
		list.add(new People("tom"));
		list.add(new People("rose"));
		list.add(new People("john"));
		newyork.setChildren(list);
		
		//��ɼ���
		list = new ArrayList<>();
		list.add(new People("Sofia"));		
		list.add(new People("sarah"));		
		list.add(new People("Jennifer"));
		la.setChildren(list);
		
		//������
		list = new ArrayList<>();
		list.add(new People("�ɱ�"));		
		list.add(new People("��ڣ"));		
		list.add(new People("ɽ��"));
		tokyo.setChildren(list);
		
		//������
		list = new ArrayList<>();
		list.add(new People("������"));		
		list.add(new People("�˲���"));		
		list.add(new People("��ԫ����"));
		osaka.setChildren(list);
		
		//�������Һͳ���
		//�й�
		 //�й�
        ArrayList citys = new ArrayList();
        citys.add(beijing);
        citys.add(shanghai);
        cn.setChildren(citys);
        //����
        citys = new ArrayList();
        citys.add(newyork);
        citys.add(la);
        us.setChildren(citys);
        //�ձ�
        citys = new ArrayList();
        citys.add(tokyo);
        citys.add(osaka);
        jp.setChildren(citys);
        //�����б�
        ArrayList countrys = new ArrayList();
        countrys.add(cn);
        countrys.add(us);
        countrys.add(jp);
		return countrys;
	}
	
}
