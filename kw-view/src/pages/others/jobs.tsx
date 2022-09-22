import Layout from '@components/layout';
import Breadcrumb, {BreadcrumbItem} from '@components/other/breadcrumb';
import Instagram from '@components/sections/instagram';
import JobLayout from '@components/job';
import React from 'react';
import {useDispatch} from 'react-redux';
import styled from 'styled-components';

const SectionContainer = styled.div`
  margin-bottom: ${60 / 14}rem;
`;

const Jobs = () => {
  const dispatch = useDispatch();

  return (
    <Layout title="Shop">
      <div className="container">
        <Breadcrumb>
          <BreadcrumbItem href="/" startIcon={<i className="fas fa-home"></i>}>
            Home
          </BreadcrumbItem>
          <BreadcrumbItem>Shop</BreadcrumbItem>
        </Breadcrumb>
      </div>
      <SectionContainer>
        <JobLayout/>
      </SectionContainer>
      <Instagram/>
    </Layout>
  );
};

export default Jobs;
