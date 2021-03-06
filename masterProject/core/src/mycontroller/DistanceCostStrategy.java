package mycontroller;

import utilities.Coordinate;

/**
 * calculate cost based on the distance between nodes
 */
public class DistanceCostStrategy implements CostStrategy {

	@Override
	public float travelCost(Node fromNode, Node toNode, float carAngle) {

		Coordinate node1 = fromNode.getCoordinate();
		Coordinate node2 = toNode.getCoordinate();
		
		float xDist = Math.max(node1.x, node2.x) - Math.min(node1.x, node2.x);
		float yDist = Math.max(node1.y, node2.y) - Math.min(node1.y, node2.y);
		
		double distance = Math.sqrt(Math.pow(xDist, 2) + Math.pow(yDist, 2));
		return (float)distance + fromNode.getCost();

	}
	
	@Override
	public float travelCost(Coordinate from, Node toNode, float carAngle) {
		
		
		float xDist = toNode.getCoordinate().x - from.x;
		float yDist = toNode.getCoordinate().y - from.y;
		
		float angle = (float) Math.abs( Math.abs(carAngle) - Math.abs(Math.toDegrees(Math.atan2( yDist, xDist ))));
		double distance = Math.hypot(yDist, xDist);
		
		//System.out.println("From" + " : " + from.toString());
		//System.out.println("To" + " : " + toNode.getCoordinate().toString());
		//System.out.println("carAngle" + " : " + carAngle);
		//System.out.println(toNode.getCoordinate().toString() + " : " + angle);
		return (float)distance*angle;
	}

}
