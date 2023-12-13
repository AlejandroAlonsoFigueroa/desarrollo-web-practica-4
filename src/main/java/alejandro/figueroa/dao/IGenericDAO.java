package alejandro.figueroa.dao;

import alejandro.figueroa.entities.GenericEntity;

public interface IGenericDAO {
	public Integer save(GenericEntity e);
	public void update(GenericEntity e);
	public void deleteById(Integer id);
	public Object getById(Integer id);
	public Integer deleteAll();
	public void getAll();
}
