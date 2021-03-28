package pl.sleipnjs.ankietaobywatelska.model;

import javax.persistence.*;

@Entity
@Table(name = "form_stage")
public class FormStage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "stage_number")
    private int stageNumber;

    @Column(name = "form_content")
    private String formContent;

    @OneToOne()
    @JoinColumn(name = "id_form", referencedColumnName = "id")
    private Form form;

    public FormStage() {
    }

    public FormStage(long id, int stageNumber, String formContent, Form form) {
        this.id = id;
        this.stageNumber = stageNumber;
        this.formContent = formContent;
        this.form = form;
    }


    public void setId(long id) {
        this.id = id;
    }

    public void setStageNumber(int stageNumber) {
        this.stageNumber = stageNumber;
    }

    public void setFormContent(String formContent) {
        this.formContent = formContent;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public long getId() {
        return id;
    }

    public int getStageNumber() {
        return stageNumber;
    }

    public String getFormContent() {
        return formContent;
    }

    public Form getForm() {
        return form;
    }

    @Override
    public String toString() {
        return "FormStage{" +
                "id=" + id +
                ", stageNumber=" + stageNumber +
                ", formContent='" + formContent + '\'' +
                ", form=" + form +
                '}';
    }
}
