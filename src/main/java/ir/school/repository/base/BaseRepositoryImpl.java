package ir.school.repository.base;

import ir.school.model.base.BaseModel;
import ir.school.util.EntityManagerSingleton;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public abstract class BaseRepositoryImpl<T extends BaseModel<Long>> implements BaseRepository<T> {
    private final Class<T> entityType;

    public BaseRepositoryImpl(Class<T> entityType) {
        this.entityType = entityType;
    }

    @Override
    public void create(T entity) {
        EntityManager em = EntityManagerSingleton.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void update(T entity) {
        EntityManager em = EntityManagerSingleton.getEntityManager();
        try {
            em.getTransaction().begin();
            Optional<T> optional = this.find(entity.getId());
            if (optional.isPresent()) {
                T managedEntity = em.merge(entity);
                updateEntity(managedEntity);
                em.getTransaction().commit();
            } else {
                em.getTransaction().rollback();
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public Optional<T> find(Long id) {
        EntityManager em = EntityManagerSingleton.getEntityManager();
        T entity = null;
        try {
            entity = em.find(entityType, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return Optional.ofNullable(entity);
    }

    @Override
    public void delete(Long id) {
        EntityManager em = EntityManagerSingleton.getEntityManager();
        Optional<T> t = find(id);
        if (t.isPresent()) {
            try {
                em.getTransaction().begin();
                T merge = em.merge(t.get());
                em.remove(merge);
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
                e.printStackTrace();
            } finally {
                em.close();
            }
        }
    }

    @Override
    public List<T> findAll() {
        TypedQuery<T> query = EntityManagerSingleton.getEntityManager().createQuery
                ("select s from " + getTableName() + " s ", entityType);
        return query.getResultList();
    }
    @Override
    public Long getCount() {
        return EntityManagerSingleton.getEntityManager().createQuery
                ("select count (e) from Student e", Long.class).getSingleResult();
    }

    protected abstract String getTableName();
    protected abstract void updateEntity(T entity);
}
