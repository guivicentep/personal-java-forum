package br.com.gvp.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gvp.forum.modelo.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{

	Curso findByNome(String nomeCurso);	

}
