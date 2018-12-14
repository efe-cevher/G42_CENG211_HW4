package business;

import java.util.List;

public class BuildingNode extends Node {

	private final int DEFAULT_VALUE = 6;
	private BuildingType type;

	public BuildingNode(int nodeId, String name, BuildingType type) {
		super(nodeId, name);
		setType(type);
	}
	
	public BuildingType getType() {
		return type;
	}

	@Override
	public double getDistance(Node other) {
		switch (getType()) {
		case ADMINISTRATIVE:
			return getAdministrativeDistance(other);
			
		case CAFETERIA:
			return getCafeteriaDistance(other);
			
		case DEPARTMENT:
			return getDepartmentDistance(other);
			
		case FACILITIES:
			return getFacilitiesDistance(other);
			
		default:
			return DEFAULT_VALUE;
		}
	}
	private double getAdministrativeDistance(Node other) {
		if(other.getClass() ==BuildingNode.class) {
			BuildingNode node = (BuildingNode)other;
			switch (node.getType()) {
			case DEPARTMENT:
				return DEFAULT_VALUE/2;
			default:
				return DEFAULT_VALUE;
			}
		}else {
			return DEFAULT_VALUE;
		}
	}
	private double getCafeteriaDistance(Node other) {
		if(other.getClass() ==BuildingNode.class) {
			BuildingNode node = (BuildingNode)other;
			switch (node.getType()) {
			case DEPARTMENT:
				return (DEFAULT_VALUE*2)-3;
			case FACILITIES:
				return Math.abs(Math.sqrt(DEFAULT_VALUE));
			default:
				return DEFAULT_VALUE;
			}
		}else {
			LandscapeNode node = (LandscapeNode)other;
			switch (node.getType()) {
			case WATERFALL:
				return DEFAULT_VALUE/3;
			case HISTORICAL_RUIN:
				return DEFAULT_VALUE*DEFAULT_VALUE;
			default:
				return DEFAULT_VALUE;
			}
		}
	}
	private double getDepartmentDistance(Node other) {
		if(other.getClass() ==BuildingNode.class) {
			BuildingNode node = (BuildingNode)other;
			switch (node.getType()) {
			case CAFETERIA:
				return (DEFAULT_VALUE*2)-3;
			case ADMINISTRATIVE:
				return DEFAULT_VALUE/2;
			default:
				return DEFAULT_VALUE;
			}
		}else {
			LandscapeNode node = (LandscapeNode)other;
			switch (node.getType()) {
			case BEACH:
				return ((DEFAULT_VALUE*DEFAULT_VALUE)/2)+4;
			default:
				return DEFAULT_VALUE;
			}
		}
	}
	private double getFacilitiesDistance(Node other) {
		if(other.getClass() ==BuildingNode.class) {
			BuildingNode node = (BuildingNode)other;
			switch (node.getType()) {
			case CAFETERIA:
				return Math.abs(Math.sqrt(DEFAULT_VALUE));
			default:
				return DEFAULT_VALUE;
			}
		}else {
			LandscapeNode node = (LandscapeNode)other;
			switch (node.getType()) {
			case WATERFALL:
				return (DEFAULT_VALUE*5)/2;
			default:
				return DEFAULT_VALUE;
			}
		}
	}


	private void setType(BuildingType type) {
		this.type = type;
	}

	

}
