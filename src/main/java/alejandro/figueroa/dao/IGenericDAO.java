package alejandro.figueroa.dao;

import java.util.List;

import alejandro.figueroa.entities.GenericEntity;

public interface IGenericDAO {
	public Integer save(GenericEntity e);
	public void update(GenericEntity e);
	public Integer deleteById(Integer id);
	public Object getById(Integer id);
	public Integer deleteAll();
	public List<GenericEntity> getAll();
}
