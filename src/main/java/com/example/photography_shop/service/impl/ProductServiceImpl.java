package com.example.photography_shop.service.impl;

import com.example.photography_shop.entity.Product;
import com.example.photography_shop.repository.ProductRepository;
import com.example.photography_shop.repository.UserRepository;
import com.example.photography_shop.service.ProductService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Value("${resources.location}")
    private String resourcesLocation;

    private final Character SEPARATOR = '.';

    @Override
    public Product update(Product product) {
        Product oldProduct = productRepository.findById(String.valueOf(product.getId())).get();
        oldProduct.setAccessible(product.getAccessible());
        oldProduct.setCategory(product.getCategory());
        oldProduct.setDescriptionProduct(product.getDescriptionProduct());
        oldProduct.setLinkToPhotos(product.getLinkToPhotos());
        oldProduct.setPrice(product.getPrice());
        oldProduct.setYear(product.getYear());
        oldProduct.setProductName(product.getProductName());
        return productRepository.save(oldProduct);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void delete(String productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getByIdProduct(Long id) {
        return productRepository.getOne(id.toString());
    }

    @Override
    public List<Product> getByAccessProduct() {
        return productRepository.findAllByAccessible(false);
    }

    @Override
    public List<Product> getByPrivateAccessProduct() {
        return productRepository.findAllByAccessible(true);
    }

    @Override
    public Iterable<Product> findByCategoryId(Long categoryId) {
        return productRepository.findAllByCategoryId(categoryId);
    }

    @Override
    public Iterable<Product> findByCategories(List<Integer> categories) {
        return null;
    }

    public String buildUniquePhotoPath(String originalName) {
        int lastDot = originalName.lastIndexOf(SEPARATOR);
        StringBuilder result = new StringBuilder();
        result.append(originalName.substring(0, lastDot));
        result.append(new Date().getTime());
        result.append(originalName.substring(lastDot));
        return result.toString();
    }

    public void saveImageToStorage(MultipartFile file, Product editableProduct) {
        makeResourceDirIfNeeded();
        if (!file.isEmpty()) {
            File fileToSave = createFileToSave(file, editableProduct);
            try (FileOutputStream fos = new FileOutputStream(fileToSave)) {
                fos.write(file.getBytes());
            } catch (IOException e) {
               // logger.error("ERROR during saving of the image: ", e);
            }
        }
    }

    public byte[] getProductImageContent(Product product) {
        byte[] result = null;
        try {
            Path path = Paths.get(resourcesLocation, product.getLinkToPhotos());
            File file = new File(path.toUri());
            result = IOUtils.toByteArray(new FileInputStream(file));
        } catch (IOException e) {
           // logger.error("ERROR during getting image content: ", e);
        }
        return result;
    }

    private void makeResourceDirIfNeeded() {
        File directory = new File(resourcesLocation);
        if (!directory.exists()) {
            directory.mkdir();
        }
    }

    private File createFileToSave(MultipartFile file, Product editableProduct) {
        String photoPath = buildUniquePhotoPath(file.getOriginalFilename());
        editableProduct.setLinkToPhotos(photoPath);
        Path fullPath = Paths.get(resourcesLocation, photoPath);
        File fileToSave = new File(fullPath.toUri());
        try {
            fileToSave.createNewFile();
        } catch (IOException e) {
           // logger.error("ERROR during the file creation: ", e);
        }
        return fileToSave;
    }
}
