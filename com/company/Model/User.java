package com.company.Model;

public class User implements IObserver
{
    private String name;
    private String username;
    private String password;
    private short role;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }

    @Override
    public void update(TemperatureCriticalMessage message) {
        System.out.println(message);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(Builder builder)
    {
        this.name = builder.name;
        this.username = builder.username;
        this.password = builder.password;
        this.role = builder.role;
    }

    public short getRole() {
        return role;
    }

    public void setRole(short role) {
        this.role = role;
    }

    public static class Builder
    {
        private String name;
        private String username;
        private String password;
        private short role;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder role(short role) {
            this.role = role;
            return this;
        }

        public Builder uUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public User build()
        {
            return new User(this);
        }
    }

}
