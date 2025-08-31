<template>
  <nav class="navigation">
    <div class="nav-container">
      <router-link to="/" class="nav-item" :class="{ active: $route.name === 'Home' }">
        HOME
      </router-link>
      <router-link to="/tickets" class="nav-item" :class="{ active: $route.name === 'Tickets' }">
        TICKETS
      </router-link>
      <router-link to="/movies" class="nav-item" :class="{ active: $route.name === 'Movies' }">
        MOVIES
      </router-link>
      <router-link to="/cinemas" class="nav-item" :class="{ active: $route.name === 'Cinemas' }">
        CINEMAS
      </router-link>
      <router-link to="/payment" class="nav-item" :class="{ active: $route.name === 'Payment' }">
        PAYMENT
      </router-link>
      <router-link to="/trailers" class="nav-item" :class="{ active: $route.name === 'Trailers' }">
        TRAILERS
      </router-link>
      <router-link to="/events-promos" class="nav-item" :class="{ active: $route.name === 'EventsPromos' }">
        EVENTS & PROMOS
      </router-link>
      <router-link to="/advertise" class="nav-item" :class="{ active: $route.name === 'Advertise' }">
        ADVERTISE WITH US
      </router-link>
      <router-link to="/contact" class="nav-item" :class="{ active: $route.name === 'Contact' }">
        CONTACT US
      </router-link>
      <router-link to="/login" class="nav-item login-link" :class="{ active: $route.name === 'Login' }">
        LOGIN
      </router-link>
    </div>
  </nav>
</template>

<script>
export default {
  name: 'Navigation'
}
</script>

<style scoped>
.navigation {
  background: #333;
  padding: 0;
}

.nav-container {
  max-width: 1200px;
  margin: 0 auto;
  display: flex;
  gap: 0;
}

.nav-item {
  color: white;
  text-decoration: none;
  padding: 15px 20px;
  display: block;
  transition: background-color 0.3s;
  border-right: 1px solid #555;
}

.nav-item:hover,
.nav-item.active {
  background: #ff6b35;
}
.login-link.active {
  background: #4CAF50;
  color: #fff;
  font-weight: bold;
  border-radius: 0 0 15px 15px;
  box-shadow: 0 2px 8px rgba(76,175,80,0.2);
}
</style>