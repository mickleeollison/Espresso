angular.module('myApp').factory('entitiesFactory',['$http', function($http){
    return{
    	
        getIngredients: function(){
            return $http.get('ingredients');
        },
        
        getIngredient: function(id){
            return $http.get('ingredients/'+id);
        },
        
        deleteIngredients: function(id){
            return $http.delete('ingredients/' + id);
        },
        
    	postIngredient: function(ingredient){
    		return $http.post("ingredients", ingredient)
    	},
    	
    	putIngredient: function(ingredient, id){
    		return $http.put("ingredients/"+id, ingredient)
    	},
    	
        getGoods: function(){
            return $http.get('bakedgoods');
        },
        
        getGood: function(id){
            return $http.get('bakedgoods/'+id);
        },
        
        deleteGood: function(id){
            return $http.delete('bakedgoods/' + id);
        },
        
    	postGood: function(good){
    		return $http.post("bakedgoods", good)
    	},
    	
    	putGood: function(good, id){
    		return $http.put("bakedgoods/"+id, good)
    	},
    	
    	 getCategories: function(){
             return $http.get('categories');
         },
         
         getAllergens: function(){
             return $http.get('allergens');
         },
         
         getDrinks: function(){
             return $http.get('drinks');
         },
         
         getDrink: function(id){
             return $http.get('drinks/'+id);
         },
         
         deleteDrink: function(id){
             return $http.delete('drinks/' + id);
         },
         
     	postDrink: function(drink){
     		return $http.post("drinks", drink)
     	},
     	
     	putDrink: function(drink, id){
     		return $http.put("drinks/"+id, drink)
     	},
    	getCurrentUser: function(){
    		return $http.get("user/getCurrent")
    	}

    	
    }
}])