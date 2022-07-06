package br.com.gvp.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gvp.forum.modelo.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long>{

}
