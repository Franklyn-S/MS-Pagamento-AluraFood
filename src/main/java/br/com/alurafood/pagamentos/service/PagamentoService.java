package br.com.alurafood.pagamentos.service;

import br.com.alurafood.pagamentos.dto.PagamentoDto;
import br.com.alurafood.pagamentos.models.Pagamento;
import br.com.alurafood.pagamentos.models.Status;
import br.com.alurafood.pagamentos.repository.PagamentoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {

	@Autowired
	private PagamentoRepository repository;

	@Autowired
	private ModelMapper modelMapper;

	public Page<PagamentoDto> obterTodos(Pageable paginacao) {
		return repository
				.findAll(paginacao)
				.map(p -> modelMapper.map(p, PagamentoDto.class));
	}

	public PagamentoDto obterPorId(Long id) {
		Pagamento pagamento = repository.findById(id)
				.orElseThrow(EntityNotFoundException::new);

		return modelMapper.map(pagamento, PagamentoDto.class);
	}

	public PagamentoDto criarPagamento(PagamentoDto pagamentoDto) {
		Pagamento pagamento = modelMapper.map(pagamentoDto, Pagamento.class);
		pagamento.setStatus(Status.CRIADO);
		repository.save(pagamento);

		return modelMapper.map(pagamento, PagamentoDto.class);
	}

	public PagamentoDto atualizarPagamento(Long id, PagamentoDto dto) {
		var pagamento = modelMapper.map(dto, Pagamento.class);
		pagamento.setId(id);
		pagamento = repository.save(pagamento);
		return modelMapper.map(pagamento, PagamentoDto.class);
	}

	public void deletarPagamento(Long id) {
		repository.deleteById(id);
	}
}
