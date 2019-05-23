package com.openclassrooms.shop.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Cart {
	
	List<CartLine> cartLineList = new ArrayList<>();
	//CH : A new list was created to facilitate the cartline

    /**
     *
     * @return the actual cartline list
     */
    public List<CartLine> getCartLineList() {
        return cartLineList;
    }

    /**
     * Adds a getProductById in the cart or increment its quantity in the cart if already added
     * @param product getProductById to be added
     * @param quantity the quantity
     */
    public void addItem(Product product, int quantity)
    {
        
    	for (CartLine cartLine : cartLineList) {
    		if (cartLine.getProduct().equals(product)){
    			cartLine.setQuantity(quantity+cartLine.getQuantity());
    	        return;		
    		}
    	}
        cartLineList.add(new CartLine(product, quantity));	
    }


    /**
     * Removes a getProductById form the cart
     * @param product the getProductById to be removed
     */
    public void removeLine(Product product) {
        getCartLineList().removeIf(l -> l.getProduct().getId().equals(product.getId()));
    }


    /**
     * @return total value of a cart
     */
    public double getTotalValue()
    {
    	//CH : product multiple by price
    	double totalValue = 0;
    	 for(CartLine cartLine: cartLineList) {
    		totalValue = totalValue +(cartLine.getQuantity()*cartLine.getProduct().getPrice());
    	}	
          return totalValue;
    }

    /**
     * @return Get average value of a cart
     */
    public double getAverageValue()
    {
    	 // CH : discover the value per unit
    	double quantity = 0;
    	for (CartLine cartLine: cartLineList) {
    		quantity = quantity + (cartLine.getQuantity());
    	}	
        return getTotalValue()/quantity;
    }

    /**
     * @param productId the getProductById id to search for
     * @return getProductById in the cart if it finds it
     */
    public Product findProductInCartLines(Long productId)
    {
    	//CH : find product in the cartline by Id
    	for(CartLine cartLine: cartLineList) {
    	   if (cartLine.getProduct().getId().equals(productId)) {  		 
    	   }
    	     return cartLine.getProduct();	 
    	}
        return null;
    }
    /**
     *
     * @param index index of the cartLine
     * @return CartLine in that index
     */
    public CartLine getCartLineByIndex(int index)
    {
        return getCartLineList().get(index);
    }

    /**
     * Clears a the cart of all added products
     */
    public void clear()
    {
        List<CartLine> cartLines = getCartLineList();
        cartLines.clear();
    }
}
