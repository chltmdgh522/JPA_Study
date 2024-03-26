package hellojpa.section7;

import jakarta.persistence.MappedSuperclass;

import java.time.LocalDateTime;

@MappedSuperclass // 매핑되는 컬럼들을 모아 놓은 것 즉 공통의 매핑을 처리하는 것
public abstract class BaseEntity {

    private String createBy;

    private LocalDateTime createdDate;

    private String modify;
    private LocalDateTime modifyDate;

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getModify() {
        return modify;
    }

    public void setModify(String modify) {
        this.modify = modify;
    }

    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(LocalDateTime modifyDate) {
        this.modifyDate = modifyDate;
    }
}
