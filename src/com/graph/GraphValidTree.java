package com.graph;

/**
 * 1. Look for trivial cycles: If graph is a directed graph this is not a concern but for undirected graph,
 *    A -> B and B -> A will be considered as cycle (which isn't). We can either modify the adjacency list or
 *    use a map to keep track of the parent node.
 *
 * 2. For a graph to be fully connected and a tree: If we revisit a node, the graph contains cycle. Use a map or simply
 *    keep track of the previous node.
 */
public class GraphValidTree {

}
