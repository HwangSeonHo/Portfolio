package fooddk.service.arduino;

import java.util.List;

import fooddk.dao.arduino.ItemDao;
import fooddk.domain.Item;

public class ItemServiceImpl implements ItemService{

	ItemDao itemDao;

	/* (non-Javadoc)
	 * @see fooddk.service.arduino.ItemService#setPorceDao(fooddk.dao.arduino.ItemDao)
	 */
	@Override
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}
	
	/* (non-Javadoc)
	 * @see fooddk.service.arduino.ItemService#selectAll()
	 */
	@Override
	public List<Item> selectAll(){
		return itemDao.selectAll();
	}
	
	/* (non-Javadoc)
	 * @see fooddk.service.arduino.ItemService#selectByNo(int)
	 */
	@Override
	public Item selectByNo(int i_no){
		return itemDao.selectByNo(i_no);
	}
	
	/* (non-Javadoc)
	 * @see fooddk.service.arduino.ItemService#insert(fooddk.domain.Item)
	 */
	@Override
	public int insert(Item item){
		return itemDao.insert(item);
	}
	
	/* (non-Javadoc)
	 * @see fooddk.service.arduino.ItemService#update(fooddk.domain.Item)
	 */
	@Override
	public int update(Item item){
		return itemDao.update(item);
	}

	/* (non-Javadoc)
	 * @see fooddk.service.arduino.ItemService#delete(int)
	 */
	@Override
	public int delete(int i_no){
		return itemDao.delete(i_no);
	}
}
