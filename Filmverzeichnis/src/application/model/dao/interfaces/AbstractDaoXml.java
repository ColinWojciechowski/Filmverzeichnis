package application.model.dao.interfaces;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDaoXml <Dto, Entity, OtherDto> implements IDao<Dto>{
	protected List<Dto> dtoList;
	protected List<Entity> entityList;
	public AbstractDaoXml dao;
	
	protected abstract Dto convertEntityToDto(Entity entity, List<OtherDto> otherDtoList);
	
	protected abstract Dto convertEntityToDto(Entity entity);

	protected abstract Entity createNewEntity(Dto dto);
	
	protected abstract boolean isEntityIdEqualDtoId(Dto dto, Entity entity);
	
	protected abstract List<Entity> loadEntityList() throws Exception;
	
	public List<Dto> getAllWithoutRelations() {
    	dtoList.clear();
    	try {
			entityList = loadEntityList();			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	if(entityList != null){	
    		fillDtoListWithoutRelations();
    	} else {
    		return new ArrayList<Dto>();
    	}   		
    	
        return dtoList;
	}
    
	protected void addNewEntity(Dto dto){
    	Entity newEntity = createNewEntity(dto);    
    	entityList.add(newEntity);	
    }

	protected void deleteDto(Dto dto) {
		Entity entity = null;
		for(Entity currentEntity : entityList){
			if(isEntityIdEqualDtoId(dto, entity)){
				entity = currentEntity;
			}
		}
		entityList.remove(entity);
		dtoList.remove(dto);
	}
		
	protected void fillDtoList() {
		Dto currentDto;
		for(Entity entity : entityList){
			List<OtherDto> otherDtos = dao.getAllWithoutRelations();
			currentDto = convertEntityToDto(entity, otherDtos);
			dtoList.add(currentDto);
		}
	}
	
	protected void fillDtoListWithoutRelations() {
		Dto currentDto;
		for(Entity entity : entityList){
			currentDto = convertEntityToDto(entity);
			dtoList.add(currentDto);
		}
	}
}
