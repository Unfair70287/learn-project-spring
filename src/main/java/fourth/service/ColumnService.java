package fourth.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fourth.bean.ColumnBean;
import fourth.dao.ColumnDAO1;

@Service
@Transactional
public class ColumnService {
	@Autowired
	private ColumnDAO1 columnDao;
	public boolean insertColumn(ColumnBean column) {
		return columnDao.insertColumn(column);
	}
	public ColumnBean updateColumn(ColumnBean column) {
		return columnDao.updateColumn(column);
	}
	public ColumnBean selectByArticleNo(int article_no) {
		return columnDao.selectByArticleNo(article_no);
	}
	public List<ColumnBean> selectAllColumns() {
		return columnDao.selectAllColumns();
	}
	public boolean deleteColumnByNo(int article_no) {
		return columnDao.deleteColumnByNo(article_no);
	}
}
