package four.pda.dao;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import four.pda.dao.Article;
import four.pda.dao.SearchArticle;

import four.pda.dao.ArticleDao;
import four.pda.dao.SearchArticleDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig articleDaoConfig;
    private final DaoConfig searchArticleDaoConfig;

    private final ArticleDao articleDao;
    private final SearchArticleDao searchArticleDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        articleDaoConfig = daoConfigMap.get(ArticleDao.class).clone();
        articleDaoConfig.initIdentityScope(type);

        searchArticleDaoConfig = daoConfigMap.get(SearchArticleDao.class).clone();
        searchArticleDaoConfig.initIdentityScope(type);

        articleDao = new ArticleDao(articleDaoConfig, this);
        searchArticleDao = new SearchArticleDao(searchArticleDaoConfig, this);

        registerDao(Article.class, articleDao);
        registerDao(SearchArticle.class, searchArticleDao);
    }
    
    public void clear() {
        articleDaoConfig.getIdentityScope().clear();
        searchArticleDaoConfig.getIdentityScope().clear();
    }

    public ArticleDao getArticleDao() {
        return articleDao;
    }

    public SearchArticleDao getSearchArticleDao() {
        return searchArticleDao;
    }

}
