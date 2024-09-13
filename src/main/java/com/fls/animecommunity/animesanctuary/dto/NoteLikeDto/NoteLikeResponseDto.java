package com.fls.animecommunity.animesanctuary.dto.NoteLikeDto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * NoteLikeResponseDto에 필요한 정보 : 
 * 		어떤 게시물인지 noteId
 * 		좋아요 여부 isLiked
 * 		좋아요 수 likeCount 
 * 		성공여부 message
 * 		
 * 
 * 		좋아요를 누른 사용자의 정보 memberid 는 좋아요를 누른 사람이 1000 ~2000 되는데 그 모든 정보가 필요하지도 않고 개인정보니까 노출되면 안되지
 * 		그러므로 뺐음 ...라고 생각했으나 그때는 null처리하면 되고 
 * 		지금 dto를 분리하지않은 상황이라 memberId도 넣음
 * 
 * 		
 */

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class NoteLikeResponseDto {
	
	@NotNull(message = "Note ID is required")
	private Long noteId; // 해당 게시물 ID
	
	private Long memberId; // 좋아요를 누른 사용자 ID
	
	private Boolean isLiked; // 좋아요 여부 (true = 좋아요, false = 좋아요 취소)
	
	private Long likeCount;  // 게시물의 총 좋아요 수
	
	private String message;  // 사용자에게 반환할 메시지
	
	//Custom Constructor
	public NoteLikeResponseDto(Long noteId, boolean isLiked, Long likeCount, String message) {
		// TODO Auto-generated constructor stub
		this.noteId = noteId;
		this.isLiked = isLiked;
		this.likeCount = likeCount;
		this.message = message;
	}


}
