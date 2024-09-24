package org.victorc.compras.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.victorc.compras.entity.Compra;

@Repository
public interface CompraRepository extends CrudRepository<Compra, Long> {
}
