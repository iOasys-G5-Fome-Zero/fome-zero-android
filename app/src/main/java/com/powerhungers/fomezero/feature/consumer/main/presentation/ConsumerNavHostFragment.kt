package com.powerhungers.fomezero.feature.consumer.main.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.powerhungers.fomezero.R
import com.powerhungers.fomezero.databinding.FragmentConsumerNavHostBinding
import com.powerhungers.fomezero.feature.consumer.basket.presentation.BasketFragment
import com.powerhungers.fomezero.feature.consumer.donation.presentation.DonationFragment
import com.powerhungers.fomezero.feature.consumer.home.presentation.ConsumerHomeFragment
import com.powerhungers.fomezero.feature.profile.presentation.ProfileFragment

class ConsumerNavHostFragment : Fragment() {

    private val binding by lazy { FragmentConsumerNavHostBinding.inflate(layoutInflater) }
    private val consumerHomeFragment = ConsumerHomeFragment()
    private val basketFragment = BasketFragment()
    private val donationFragment = DonationFragment()
    private val profileFragment = ProfileFragment()

    private var activeFragment: Fragment = consumerHomeFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        setupBottomNav()
    }

    private fun setupBottomNav() {
        handleFragmentVisibility()

        with(binding) {
            consumerBottomNavHost.setOnNavigationItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.home_consumer ->
                        handleFragmentTransaction(consumerHomeFragment)
                    R.id.my_basket_consumer ->
                        handleFragmentTransaction(basketFragment)
                    R.id.donations_consumer ->
                        handleFragmentTransaction(donationFragment)
                    R.id.profile_consumer ->
                        handleFragmentTransaction(profileFragment)
                }
                true
            }
        }
    }

    private fun handleFragmentVisibility() {
        if (!consumerHomeFragment.isAdded) {
            childFragmentManager.beginTransaction()
                .add(R.id.consumerNavHostContainer, consumerHomeFragment)
                .commit()
        }
        if (!basketFragment.isAdded) {
            addAndHideFragment(basketFragment)
        }
        if (!donationFragment.isAdded) {
            addAndHideFragment(donationFragment)
        }
        if (!profileFragment.isAdded) {
            addAndHideFragment(profileFragment)
        }
    }

    private fun addAndHideFragment(fragment: Fragment) {
        childFragmentManager.beginTransaction().add(R.id.consumerNavHostContainer, fragment)
            .hide(fragment)
            .commit()
    }

    private fun handleFragmentTransaction(fragment: Fragment) {
        childFragmentManager.beginTransaction()
            .hide(activeFragment)
            .show(fragment)
            .commit()
        activeFragment = fragment
    }
}