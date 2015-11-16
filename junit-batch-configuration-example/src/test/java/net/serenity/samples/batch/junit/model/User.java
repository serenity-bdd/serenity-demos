package net.serenity.samples.batch.junit.model;

/**
 * User: YamStranger
 * Date: 11/12/15
 * Time: 3:51 PM
 */
public class User {
    private final String login;
    private final String email;

    public User(final String login, final String email) {
        this.login = login;
        this.email = email;
    }

    public String getLogin() {
        return this.login;
    }

    public String getEmail() {
        return this.email;
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) return true;
        if (object == null || this.getClass() != object.getClass()) return false;

        User user = (User) object;

        if (this.login != null ?
                !this.login.equals(user.login)
                : user.login != null)
            return false;
        return !(this.email != null ?
                !this.email.equals(user.email)
                : user.email != null);
    }

    @Override
    public int hashCode() {
        int result = this.login != null ? this.login.hashCode() : 0;
        result = 31 * result + (this.email != null ? this.email.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
            "login='" + login + '\'' +
            ", email=" + email +
            '}';
    }
}