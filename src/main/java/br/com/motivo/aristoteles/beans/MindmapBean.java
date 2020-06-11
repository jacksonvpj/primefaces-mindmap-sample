package br.com.motivo.aristoteles.beans;

import java.io.Serializable;
import java.util.UUID;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.mindmap.DefaultMindmapNode;
import org.primefaces.model.mindmap.MindmapNode;

@ManagedBean(name = "mindmapBean")
@RequestScoped
public class MindmapBean implements Serializable {

	private static final long serialVersionUID = 8933331066064494295L;

	private MindmapNode root;

    private MindmapNode selectedNode;

    public MindmapBean() {
        root = new DefaultMindmapNode("google.com", "Google", "FFCC00", false);

        MindmapNode ips = new DefaultMindmapNode("IPs", "IP Nos", "6e9ebf", true);
        MindmapNode ns = new DefaultMindmapNode("NS(s)", "Names", "6e9ebf", true);
        MindmapNode mw = new DefaultMindmapNode("Mw", "Malicious ", "6e9ebf", true);

        root.addNode(ips);
        root.addNode(ns);
        root.addNode(mw);
    }

    public MindmapNode getRoot() {
        return root;
    }

    public MindmapNode getSelectedNode() {
        return selectedNode;
    }
    public void setSelectedNode(MindmapNode selectedNode) {
        this.selectedNode = selectedNode;
    }

	public void onNodeSelect(SelectEvent<MindmapNode> event) {
		MindmapNode node = event.getObject();

        //populate if not already loaded
        if(node.getChildren().isEmpty()) {
            Object label = node.getLabel();

            if(label.equals("NS(s)")) {
                for(int i = 0; i < 25; i++) {
                    node.addNode(new DefaultMindmapNode("ns" + i + ".google.com", "Namespace " + i + " of Google", "82c542", false));
                }
            }
            else if(label.equals("IPs")) {
                for(int i = 0; i < 18; i++) {
                    node.addNode(new DefaultMindmapNode("1.1.1."  + i, "IP Number: 1.1.1." + i, "fce24f", false));
                }
            }
            else if(label.equals("Malware")) {
                for(int i = 0; i < 18; i++) {
                    String random = UUID.randomUUID().toString();
                    node.addNode(new DefaultMindmapNode("Malware-"  + random, "Malicious Software: " + random, "3399ff", false));
                }
            }
        }
    }

	public void onNodeDblselect(SelectEvent<MindmapNode> event) {
		this.selectedNode = event.getObject();
    }
}