package mobalDev.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass // cette classe n'est pas une entité, mais ses champs seront enregistrés en base
public abstract class AbstractEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id;
	
	private LocalDateTime create_at;
	private LocalDateTime update_at;
	
	private int modificationcounter;
	
	protected AbstractEntity() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getCreate_at() {
		return create_at;
	}

	public void setCreate_at(LocalDateTime create_at) {
		this.create_at = create_at;
	}

	public LocalDateTime getUpdate_at() {
		return update_at;
	}

	public void setUpdate_at(LocalDateTime update_at) {
		this.update_at = update_at;
	}

	public int getModificationcounter() {
		return modificationcounter;
	}

	public void setModificationcounter(int modificationcounter) {
		this.modificationcounter = modificationcounter;
	}

}
