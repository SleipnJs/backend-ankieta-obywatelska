package pl.sleipnjs.ankietaobywatelska.model;

import javax.persistence.*;

@Entity
@Table(name = "form_responses")
public class FormResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne()
    @JoinColumn(name = "id_form", referencedColumnName = "id")
    private Form form;

    @Column(name = "field_key")
    private String formKey;

    @Column(name = "response")
    private String response;

    public FormResponse() {
    }

    public FormResponse(long id, Form form, String formKey, String response) {
        this.id = id;
        this.form = form;
        this.formKey = formKey;
        this.response = response;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public void setFormKey(String formKey) {
        this.formKey = formKey;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public long getId() {
        return id;
    }

    public Form getForm() {
        return form;
    }

    public String getFormKey() {
        return formKey;
    }

    public String getResponse() {
        return response;
    }
}
