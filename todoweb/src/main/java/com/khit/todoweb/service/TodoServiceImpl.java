package com.khit.todoweb.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.khit.todoweb.dto.PageRequestDTO;
import com.khit.todoweb.dto.PageResponseDTO;
import com.khit.todoweb.dto.TodoDTO;
import com.khit.todoweb.mapper.TodoMapper;
import com.khit.todoweb.vo.TodoVO;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TodoServiceImpl implements TodoService{
	
	private TodoMapper todoMapper;
	
	private ModelMapper modelMapper;

	@Override
	public void insert(TodoDTO todoDTO) {
		// DTO�� VO�� ��ȯ -> DB�� ������ ���� ����
		
		// 1. ���(ModelMapper)�� ��� ���� ���,
		/* TodoVO todoVO = TodoVO.builder()
					.title(todoDTO.getTitle())
					.writer(todoDTO.getWriter())
					.build(); */
		
		// 2. ���(ModelMapper)�� ����� ���,
		TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
		
		todoMapper.insert(todoVO);
	}

	@Override
	public List<TodoDTO> findAll() {
		// VO�� DTO�� ��ȯ -> DB�� ������ �������� ����
		
		// vo ����Ʈ ������ ��������
		List<TodoVO> voList = todoMapper.findAll();
		
		// DB���� ������ �����͸� ���� ��ü : DTO�� ��ȯ�ؼ� ��ȯ
		// List<TodoDTO> dtoList = new ArrayList<>();
		// for�� ����ϸ� ��ü �Խñ� �ҷ�����
		// for(TodoVO todoVO : voList) {			
			// �Խñ� 1�� ���� = �󼼺���
			// VO -> DTO�� ��ȯ
			// TodoDTO todoDTO = TodoDTO.builder()
					// .tno(todoVO.getTno())
					// .title(todoVO.getTitle())
					// .writer(todoVO.getWriter())
					// .build();
			// list�� ���
			// dtoList.add(todoDTO);
		// }
		
		// vo ����Ʈ�� dto�� �����ϰ� ��ȯ�� (���ٽ����� ����)
		// �� ������ ����ϱ⸦ ���� - ���� �������� ����
	    List<TodoDTO> dtoList = voList.stream()
							    .map(vo -> modelMapper.map(vo, TodoDTO.class))
   						        .collect(Collectors.toList());
		
		return dtoList;
	}

	@Override
	public TodoDTO findById(Long tno) {
		// VO�� �����ͼ� DTO�� ��ȯ
		TodoVO todoVO = todoMapper.findById(tno);
		
		/* TodoDTO todoDTO = TodoDTO.builder()
						  .tno(todoVO.getTno())
						  .title(todoVO.getTitle())
						  .writer(todoVO.getWriter())
						  .build(); */
		
		TodoDTO todoDTO = modelMapper.map(todoVO, TodoDTO.class);
		
		return todoDTO;
	}
	// �ۼ���ó��
	@Override
	public void update(TodoDTO todoDTO) {
		// dto�� vo�� ��ȯ
		TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
		todoMapper.update(todoVO);
	}
	// �����ϱ�
	@Override
	public void delete(Long tno) {
		todoMapper.delete(tno);
	}
	
	// ������ ���(��ȣ) ó��
	@Override
	public PageResponseDTO<TodoDTO> pagingList(PageRequestDTO pageRequestDTO) {
		
		// DB���� voList ��������
		List<TodoVO> voList = todoMapper.pagingList(pageRequestDTO);
		
		// viList�� dtoList�� ��ȯ (���ٽ�..)
		List<TodoDTO> dtoList = voList.stream()
				.map(vo -> modelMapper.map(vo, TodoDTO.class))
				.collect(Collectors.toList());
		
		// ��ü ������ ���� ��������
		int total = todoMapper.todoCount();
		
		PageResponseDTO<TodoDTO> pageResponseDTO = PageResponseDTO.<TodoDTO>withAll()
			.dtoList(dtoList)
			.total(total)
			.pageRequestDTO(pageRequestDTO)
			.build();
		
		return pageResponseDTO;
	}

}
