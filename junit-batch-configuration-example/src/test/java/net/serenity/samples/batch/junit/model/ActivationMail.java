package net.serenity.samples.batch.junit.model;

/**
 * User: YamStranger
 * Date: 11/13/15
 * Time: 2:02 AM
 */
public class ActivationMail {
    private final String mail;
    private final String id;

    public ActivationMail(final String mail, final String id) {
        this.mail = mail;
        this.id = id;
    }

    public String getMail() {
        return this.mail;
    }

    public String getId() {
        return this.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        ActivationMail that = (ActivationMail) o;

        if (this.mail != null ?
                !this.mail.equals(that.mail)
                : that.mail != null)
            return false;
        return !(this.id != null ?
                    !this.id.equals(that.id)
                    : that.id != null);
    }

    @Override
    public int hashCode() {
        int result = this.mail != null ? this.mail.hashCode() : 0;
        result = 31 * result + (this.id != null ? this.id.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ActivationMail{" +
            "mail='" + mail + '\'' +
            ", id=" + id +
            '}';
    }
}