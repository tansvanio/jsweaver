package pt.up.fe.specs.jackdaw.joinpoints.expressions;

import com.google.gson.JsonObject;

import pt.up.fe.specs.jackdaw.JoinpointCreator;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.ABinaryExpression;
import pt.up.fe.specs.jackdaw.abstracts.joinpoints.AJoinPoint;

public class JsBinaryExpression extends ABinaryExpression {

    private final JsonObject node;

    public JsBinaryExpression(JsonObject node) {
        super(new JsExpression(node));
        this.node = node;
    }

    @Override
    public String getOperatorImpl() {
        return this.node.get("operator").getAsString();
    }

    @Override
    public AJoinPoint getLeftImpl() {
        return JoinpointCreator.create(this.node.get("left").getAsJsonObject());
    }

    @Override
    public AJoinPoint getRightImpl() {
        return JoinpointCreator.create(this.node.get("right").getAsJsonObject());
    }

    @Override
    public JsonObject getNode() {
        return this.node;
    }

}
