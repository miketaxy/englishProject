//package org.portfolio.englishproject.service.impl;
//
//import lombok.RequiredArgsConstructor;
//import org.portfolio.englishproject.DTO.CreateCategoryDTO;
//import org.portfolio.englishproject.config.JwtUtil;
//import org.portfolio.englishproject.model.Category;
//import org.portfolio.englishproject.model.User;
//import org.portfolio.englishproject.repository.CategoryRepository;
//import org.portfolio.englishproject.repository.authRepo.UserRepository;
//import org.portfolio.englishproject.service.CategoryService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//
//@RequiredArgsConstructor
//@Service
//public class CategoryServiceImpl implements CategoryService {
//
//    private final CategoryRepository categoryRepository;
//    private final UserRepository userRepository;
//    @Override
//    public ResponseEntity<Category> makeCategory(CreateCategoryDTO createCategoryDTO, String bearerToken) {
//        User user = getUser(bearerToken);
//        Category category = createCategoryDTO.toMakeCategoryDTO(user);
//        categoryRepository.save(category);
//        return ResponseEntity.ok(category);
//    }
//
////    @Override
////    public ResponseEntity<Category> deleteCategory(String category, String bearerToken) {
////        return null;
////    }
////
////    @Override
////    public ResponseEntity<Category> editCategory(Category category, String bearerToken) {
////        return null;
////    }
////
////    @Override
////    public ResponseEntity<Category> getAllCategories(String bearerToken) {
////        return null;
////    }
//
//    private User getUser(String bearerToken){
//        return userRepository.findByUsername(JwtUtil.getUsername(bearerToken)).get();
//    }
//}
