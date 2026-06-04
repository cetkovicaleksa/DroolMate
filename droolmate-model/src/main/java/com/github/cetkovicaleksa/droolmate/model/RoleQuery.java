package com.github.cetkovicaleksa.droolmate.model;

/**
 * Goal fact representing a user query for recommendations for a role.
 * Insert this fact to trigger goal-driven (backward-style) reasoning.
 */
public class RoleQuery {
    private String roleId;
    private String requester; // optional user identifier
    private long timestamp;

    public RoleQuery(String roleId) {
        this(roleId, null);
    }

    public RoleQuery(String roleId, String requester) {
        this.roleId = roleId;
        this.requester = requester;
        this.timestamp = System.currentTimeMillis();
    }

    public String getRoleId() { return roleId; }
    public String getRequester() { return requester; }
    public long getTimestamp() { return timestamp; }

    @Override
    public String toString() {
        return "RoleQuery{" + "roleId='" + roleId + '\'' + '}';
    }
}

