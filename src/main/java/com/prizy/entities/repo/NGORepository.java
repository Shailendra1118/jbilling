package com.prizy.entities.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.prizy.entities.NGO;

public class NGORepository {

	private static ArrayList<NGO> list = new ArrayList<>();
	static NGO n1 = null;
	static NGO n2 = null;
	static NGO n3 = null;
	static NGO n4 = null;
	static NGO n5 = null;

	static {
		n1 = new NGO(100L, "CRY", "save a child life today",
				"Cry is a well recognized government funded organization",
				"Children", "child-random.jpg", 3.2f);
		n2 = new NGO(
				200L,
				"Greenpeace",
				"protect the world",
				"Green Peace is the oldest NGO working in the enviornment protection like Water and Air sustainability",
				"Enviornment", "child-school.jpg", 4.1f);
		n3 = new NGO(
				300L,
				"YoSoldier",
				"Gaurd your guards",
				"This NGO is working for our brave soldiers and their well being",
				"Soldier", "child1.jpg", 2f);
		n4 = new NGO(
				400L,
				"HappyChild",
				"Save a child",
				"This NGO works for underprivileged childs who are in grave dangers if they no immediete medical help is not avaliable.",
				"Children", "child-water.jpg", 4.5f);
		n5 = new NGO(500L, "EverybodysConcern", "It is every bodys' concern.",
				"Help victims of recent tragedy in our country.", "type",
				"women-edu1.jpg", 4f);
		list.add(n1);
		list.add(n2);
		list.add(n3);
		list.add(n4);
		list.add(n5);

	}

	public List<NGO> getAllNGO() {
		return list;
	}

	public NGO getNGOById(Long id) {
		List<NGO> ngoWithIds = list.stream()
				.filter(ngo -> ngo.getId().equals(id))
				.collect(Collectors.toList());
		return ngoWithIds.get(0);
	}

}