package com.getgobo.gobopay.dto;

import java.util.Objects;

public class Server {
    private String serverId;
    private String serverName;

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Server server = (Server) o;
        return Objects.equals(getServerId(), server.getServerId()) &&
                Objects.equals(getServerName(), server.getServerName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getServerId(), getServerName());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Server{");
        sb.append("serverId='").append(serverId).append('\'');
        sb.append(", serverName='").append(serverName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
