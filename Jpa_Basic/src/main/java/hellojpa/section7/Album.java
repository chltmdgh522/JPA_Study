package hellojpa.section7;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

//@Entity
@DiscriminatorValue("A") // item dtype 컬럼 내용 album이 아니라 a로 변경
public class Album extends Item{
    private String artist;

}
