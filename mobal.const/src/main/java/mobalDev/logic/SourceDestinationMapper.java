package mobalDev.logic;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SourceDestinationMapper<T,D>{
	
	public D convertEntityToDto(T entity,D dto);
	public T convertDtoToEntity(D dto, T entity);

}
